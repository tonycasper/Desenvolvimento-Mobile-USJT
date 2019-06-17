import { Injectable } from "@angular/core";
import {AngularFireDatabase} from 'angularfire2/database';

@Injectable()
export class UsuarioService{
    constructor (private db: AngularFireDatabase){
    }

    usuario_logado = {
        id: -1,
        usuarioLogado: false,
    };

    usuario_cadastro = [
        {id: 1, nomeUsuario: 'admin', icone: 3, IconeCadastro: {}}
    ];

    icones = [
        {id: 1, nome: 'Avatar vermelho',          destino: 'assets/imgs/icones/avatar1.png'},
        {id: 2, nome: 'Avatar Amarelo',        destino: 'assets/imgs/icones/avatar2.png'},
        {id: 3, nome: 'Avatar Azul',           destino: 'assets/imgs/icones/avatar3.png'},
        {id: 4, nome: 'Avatar Verde',         destino: 'assets/imgs/icones/avatar4.png'},
        {id: 5, nome: 'Avatar Preto e Branco',  destino: 'assets/imgs/icones/avatar5.png'},
        {id: 6, nome: 'Avatar Roxo',                  destino: 'assets/imgs/icones/avatar6.png'},
        {id: 7, nome: 'Avatar Rosa',       destino: 'assets/imgs/icones/avatar7.png'},
        {id: 8, nome: 'Avatar Cinza',                  destino: 'assets/imgs/icones/avatar8.png'},
        {id: 9, nome: 'Avatar Laranja',                 destino: 'assets/imgs/icones/avatar9.png'},
        {id: 10, nome: 'Avatar Marrom',        destino: 'assets/imgs/icones/avatar10.png'},
    ];

    usuarioLogado = false;

    carregarIcones() {
        return this.icones;
    }

    fetchUsuarios() {
        let usuarios = this.db.list("/usuario_cadastro");
        return usuarios;
    }

    verificarLoginJaExiste(usuarioCadastro) {
        return false;
    }

    cadastrarELogar(usuarioCadastro) {
        usuarioCadastro.IconeCadastro = this.carregarIcone(usuarioCadastro.icone);
        this.db.list("/usuario_cadastro/").push({            
            usuarioCadastro   
        }); 
    }

    carregarUsuarioSessao() {
        let usuarioLogado = this.usuario_logado;
        let retorno: any;

        this.db.list('/usuario_cadastro').valueChanges().subscribe(usuarios => {
            usuarios.forEach(function(usuario_cadastrado: any) {
                if(usuario_cadastrado.id == usuarioLogado.id) {
                    retorno = usuario_cadastrado;
                }
            });
        });

        
        
        return retorno;
    }

    carregarIcone(idIcone) {
        let retorno = {id: -1, destino: "http://www.iconninja.com/files/111/870/406/user-people-profile-human-account-avatar-icon.png"};
        this.icones.forEach(function(icone) {
            if(idIcone == icone.id) {
                retorno = icone;
            }
        });

        return retorno;
    }
}