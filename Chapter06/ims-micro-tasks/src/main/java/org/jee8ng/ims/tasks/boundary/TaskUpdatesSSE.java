package org.jee8ng.ims.tasks.boundary;

import javax.annotation.PreDestroy;
import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;
import org.jee8ng.ims.tasks.entity.TaskUpdated;

/**
 *
 * @author prashantp.org
 */
@Singleton
@Path("updates")
public class TaskUpdatesSSE {
    
    private SseBroadcaster broadcaster;
    private Sse sse;
    
    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void subscribe(@Context Sse sse, @Context SseEventSink eventSink) {
        this.sse = sse;
        if(this.broadcaster == null) {
            this.broadcaster = sse.newBroadcaster();
        }
        this.broadcaster.register(eventSink);
    }

    //Observer of TaskUpdated Event
    public void observeTaskUpdates(@Observes TaskUpdated updated){
        if(this.broadcaster == null) {
            //No one's listening
            return;
        }
        //Broadcast the updated information to all connected clients
        String stats = JsonbBuilder.create().toJson(updated);
    	this.broadcaster.broadcast(this.sse.newEvent(stats));
    }
    
    //Release the broadcaster resource
    @PreDestroy
    public void free(){
        if(this.broadcaster != null) {
            this.broadcaster.close();
        }
    }
}
