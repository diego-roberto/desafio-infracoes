export class Infracao {
    id!: number;
    datahora!: string;
    velocidade!: number;
    placa!: string;
    veiculo!: string;

    public constructor() { }

    public initializeWithJSON(json: any): Infracao {
        this.id = json.id;
        this.datahora = this.convertDatahora(json.datahora);
        this.velocidade = json.velocidade;
        this.placa = json.placa;
        this.veiculo = json.veiculo;
        return this;
    }

    private convertDatahora(datahora: number[]): string {
        const year = datahora[0].toString().padStart(4, '0');
        const month = datahora[1].toString().padStart(2, '0');
        const day = datahora[2].toString().padStart(2, '0');
        const hour = datahora[3].toString().padStart(2, '0');
        const minute = datahora[4].toString().padStart(2, '0');
        const second = datahora[5].toString().padStart(2, '0');
        return `${day}/${month}/${year} - ${hour}:${minute}:${second}`;
      }
      

}
