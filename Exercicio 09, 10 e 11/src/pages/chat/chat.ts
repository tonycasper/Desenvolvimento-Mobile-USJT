import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { SalaService } from '../../app/sala.service'

/**
 * Generated class for the ChatPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-chat',
  templateUrl: 'chat.html',
})
export class ChatPage {

  sala;
  nome; 

  constructor(public navCtrl: NavController, public navParams: NavParams, private salaService: SalaService) {
    this.sala = this.salaService.salas[this.navParams.get("salaParam").id];
    this.nome = this.navParams.get("nomeParam")
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ChatPage');
  }

  ionViewWillLeave(){
    this.salaService.salas[this.sala.id] = this.sala.usuarios.filter(x => x.nome !== this.nome);
    console.log('Usuarios', this.salaService.salas[this.sala.id].usuarios)
  }

  enviarMensagem(nome, texto){
    this.sala.mensagens.push({
      nome: nome,
      texto: texto
    })
  }

}
