export class Infracao {
    id!: number;
    datahora!: string;
    velocidade!: number;
    placa!: string;
    veiculo!: string;

    public constructor() { }

    public initializeWithJSON(json: any): Infracao {
        this.id = json.id;
        this.datahora = json.datahora;
        this.velocidade = json.velocidade;
        this.placa = json.placa;
        this.veiculo = json.veiculo;
        return this;
    }

    toJSON() {
        return {
            id: this.id,
            datahora: this.datahora,
            velocidade: this.velocidade,
            placa: this.placa,
            veiculo: this.veiculo
        }
    }
}
