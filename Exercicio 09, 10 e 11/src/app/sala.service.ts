import { Injectable } from "@angular/core";

@Injectable()
export class SalaService {
    salas = [
        {
            id: '1',
            nome: 'Cinema',
            mensagens: [{
                nome: 'BOT',
                texto: 'Bem-vindo a sala'
            }],
            usuarios: []
        },
        {
            id: '2',
            nome: 'Curiosidades',
            mensagens: [{
                nome: 'BOT',
                texto: 'Bem-vindo a sala'
            }],
            usuarios: []
        },
        {
            id: '3',
            nome: 'Esportes',
            mensagens: [{
                nome: 'BOT',
                texto: 'Bem-vindo a sala'
            }],
            usuarios: []
        }
    ]

    nomeNaSala(nome, sala) {
        return this.salas[sala.id].usuarios.some(e => e.nome == nome)
    }
}