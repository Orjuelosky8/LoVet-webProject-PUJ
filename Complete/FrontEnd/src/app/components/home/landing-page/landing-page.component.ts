import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {
  typedText: string = '';

  constructor() { }

  ngOnInit(): void {
    this.typeText("AGENDA TU CITA CON NOSOTROS!", 1000); // El texto y el retraso inicial
  }

  typeText(text: string, delay: number): void {
    setTimeout(() => {
      for (let i = 0; i <= text.length; i++) {
        setTimeout(() => {
          this.typedText = text.slice(0, i);
        }, i * 100); // Velocidad de tipeado
      }
    }, delay);
  }
}
