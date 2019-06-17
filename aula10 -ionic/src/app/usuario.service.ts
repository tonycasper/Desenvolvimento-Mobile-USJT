import { Injectable } from "@angular/core";

@Injectable()
export class UsuarioService{
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

    verificarLoginJaExiste(usuarioCadastro) {
        let retorno = false;
        this.usuario_cadastro.forEach(function(usuarioNaBase) {
            if(usuarioNaBase.nomeUsuario == usuarioCadastro.nomeUsuario) {
                retorno = true;
            }
        });

        return retorno;
    }

    cadastrarELogar(usuarioCadastro) {
        this.usuario_logado.id = Math.floor(Math.random() * 1000) + 1;
        this.usuario_logado.usuarioLogado = true;

        usuarioCadastro.id = this.usuario_logado.id;
        this.usuario_cadastro.push(usuarioCadastro);
    }

    carregarUsuarioSessao() {
        let usuarioLogado = this.usuario_logado;
        let retorno = {id: -1, icone: -1, IconeCadastro: {}};
        this.usuario_cadastro.forEach(function(usuario_cadastrado) {
            if(usuario_cadastrado.id == usuarioLogado.id) {
                retorno = usuario_cadastrado;
            }
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