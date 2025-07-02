import { Component, ElementRef, HostListener } from '@angular/core'; // <--- ¡Asegúrate de que ElementRef esté aquí!
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-dropdown',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.scss']
})
export class DropdownComponent {
  isOpen = false;

  // Inyecta ElementRef en el constructor
  constructor(private elementRef: ElementRef) { }

  toggleDropdown() {
    this.isOpen = !this.isOpen;
  }

  // Cierra el dropdown si se hace clic fuera de él
  @HostListener('document:click', ['$event'])
  onClickOutside(event: Event) {
    if (!this.elementRef.nativeElement.contains(event.target)) {
      this.isOpen = false;
    }
  }
}
