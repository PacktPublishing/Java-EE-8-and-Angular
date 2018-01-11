import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'positiveNumbers' })
export class PositiveNumbersPipe implements PipeTransform {
  transform(value: number[]): number[] {
    return value.filter( v => v > 0);
  }
}