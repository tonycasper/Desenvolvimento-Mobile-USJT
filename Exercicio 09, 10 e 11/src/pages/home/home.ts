import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import { SalaService } from '../../app/sala.service'

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController, private salaService: SalaService, public alertCtrl: AlertController) {
  }

  onEntrarClick(nome, sala) {
    if (!this.salaService.nomeNaSala(nome, sala)) {
      sala = this.salaService.salas[sala.id];
      sala.usuarios.push({nome: nome});
      this.navCtrl.push('ChatPage', {
        nomeParam: nome,
        salaParam: sala
      })
    }
    else {
      this.alertCtrl.create({
        title: 'Usuario já existente.',
        subTitle: 'O nome o usuario deve ser único.',
        buttons: ['OK']
      }).present()
    }
  }
}
