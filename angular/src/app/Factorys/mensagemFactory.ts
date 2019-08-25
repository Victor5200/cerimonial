import Swal, {SweetAlertResult} from 'sweetalert2';

export class MensagemFactory {

  constructor() {
  }

  public publicaMensagemSucesso(textoMensagem: string): void {
    Swal.fire('', textoMensagem, 'success');
  }

  public publicaMensagemErro(textoMensagem: string): void {
    Swal.fire('', textoMensagem, 'error');
  }

  public publicaMensagemAviso(textoMensagem: string): void {
    Swal.fire('', textoMensagem, 'warning');
  }

  public publicaMensagemInfo(textoMensagem: string): void {
    Swal.fire('', textoMensagem, 'info');
  }

  public publicaMensagemConfirmacao(titulo: string, texto: string): Promise<SweetAlertResult> {
    return Swal.fire({
      title: titulo,
      text: texto,
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sim'
    });
  }
}
