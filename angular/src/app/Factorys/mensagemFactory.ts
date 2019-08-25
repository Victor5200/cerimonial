import Swal, {SweetAlertResult} from 'sweetalert2';

export class MensagemFactory {

  constructor() {
  }

  public publicaMensagemSucesso(textoMensagem: string): void {
    const Toast = Swal.mixin({
      toast: true,  position: 'top-end', showConfirmButton: false, timer: 3000
    })
    Toast.fire('', textoMensagem, 'success');
  }

  public publicaMensagemErro(textoMensagem: string): void {
    const Toast = Swal.mixin({
      toast: true,  position: 'top-end', showConfirmButton: false, timer: 3000
    })
    Toast.fire('', textoMensagem, 'error');
  }

  public publicaMensagemAviso(textoMensagem: string): void {
    const Toast = Swal.mixin({
      toast: true,  position: 'top-end', showConfirmButton: false, timer: 3000
    })
    Toast.fire('', textoMensagem, 'warning');
  }

  public publicaMensagemInfo(textoMensagem: string): void {
    const Toast = Swal.mixin({
      toast: true,  position: 'top-end', showConfirmButton: false, timer: 3000
    })
    Toast.fire('', textoMensagem, 'info');
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
