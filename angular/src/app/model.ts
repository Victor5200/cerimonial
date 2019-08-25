export class Pessoa {
  public id: number;
  public nomeCompleto: String;
  public nomeUsual: String;
  public utilizarNomeUsual: boolean;
  public login: String;
  public sobre: String;
  public foto: string | ArrayBuffer;
  public listaVinculo: Array<VinculoPessoa> = new Array<VinculoPessoa>();
  public listaCargoOrgao: Array<CargoOrgao> = new Array<CargoOrgao>();

  constructor() {}
}

export class VinculoPessoa {
  public id: number
  public nome: String;
  public tipoVinculo: String;

  constructor() {}
}

export class CargoOrgao {
  public id: number;
  public nomeCargo: String;
  public possuiOrgao: boolean;
  public orgao: Orgao;

  constructor() {}
}

export class Orgao {
  public id: number;
  public descricaoOrgao: String;
  public endereco: Endereco;

  constructor() {}
}

export class Endereco {
  public logradouro: String;
  public cidade: String;
  public pais: String;
  public cep: String;

  constructor() {}
}
