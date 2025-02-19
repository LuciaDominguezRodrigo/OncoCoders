import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {SectiontitleComponent} from '../../../components/tags/sectiontitle/sectiontitle.component';
import {HttpClient} from '@angular/common/http';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-ia-model-configuration',
  imports: [
    FormsModule,
    SectiontitleComponent,
    NgIf
  ],
  templateUrl: './model-configuration.component.html',
  styleUrl: './model-configuration.component.css'
})
export class ModelConfigurationComponent {

  selectedFile: File | null = null;
  selectedModel: string = 'modelo_1'; // Default model selection
  uploadMessage: string = '';

  constructor(private http: HttpClient) {}

  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.selectedFile = input.files[0];
    }
  }

  uploadFile() {
    if (!this.selectedFile) {
      this.uploadMessage = 'Please select a file to upload.';
      return;
    }

    const formData = new FormData();
    formData.append('file', this.selectedFile);
    formData.append('modelName', this.selectedModel);

    this.http.post('https://localhost:8443/api/diagnosis/upload', formData).subscribe(
      (response) => {
        this.uploadMessage = 'File uploaded successfully!';
      },
      (error) => {
        this.uploadMessage = 'File uploaded successfully!';
      }
    );
  }
}
