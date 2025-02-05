import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.css']
})
export class PopupComponent {
  @Input() message: string = ''; // Mensaje a mostrar en el popup
  @Output() close = new EventEmitter<void>(); // Evento para cerrar el popup

  closePopup() {
    this.close.emit();  // Emite el evento 'close' al componente padre
    location.reload();  // Recarga la página
  }
}
