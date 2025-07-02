import { Component, ElementRef, HostListener } from '@angular/core'; // <--- ¡Asegúrate de que ElementRef esté aquí!
import { CommonModule } from '@angular/common';
import {TranslationService} from '../../../services/translation.service';
import {Language} from '../../../models/language.model';

@Component({
  selector: 'app-dropdown',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dropdown.component.html',
  styleUrls: ['./dropdown.component.scss']
})
export class DropdownComponent {
  isOpen = false;
  languages: Language[] = [
    { id: 'en', name: 'English' },
    { id: 'es', name: 'Español' },
    { id: 'fr', name: 'Français' },
    { id: 'ca', name: 'Català' },
  ];

  // Inyecta ElementRef en el constructor
  constructor(private translationService: TranslationService, private elementRef: ElementRef) { }

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

  changeLanguage(id:string){
    this.toggleDropdown();
    this.translationService.changeTargetLanguage(id);
  }
}
