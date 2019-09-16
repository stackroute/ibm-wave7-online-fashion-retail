import {AbstractControl, AsyncValidator, ValidationErrors} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, catchError} from 'rxjs/operators';
import {UserService} from '../services/user.service';

export class UniqueEmailValidator implements AsyncValidator {
  constructor(private userService: UserService) {}

  validate(
    ctrl: AbstractControl
  ): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> {
    return this.userService.isEmailTaken(ctrl.value).pipe(
      map(isTaken => (isTaken ? { uniqueEmailId: true } : null)),
      catchError(() => null)
    );
  }
}
