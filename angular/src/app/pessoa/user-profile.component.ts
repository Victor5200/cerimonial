import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {Pessoa} from '../model';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormModalComponent} from '../form-modal/form-modal.component';
import {MensagemFactory} from '../Factorys/mensagemFactory';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  public pessoa: Pessoa = new Pessoa();
  private mensagemFactory: MensagemFactory = new MensagemFactory();
  display = 'none';

  constructor(private cd: ChangeDetectorRef,
              private modalService: NgbModal) { }

  ngOnInit() {
    this.pessoa.foto = '../assets/img/user.png';
  }

  executaUploadImagem(event): void {
    const reader = new FileReader();

    if (event.target.files && event.target.files.length) {
      const [file] = event.target.files;
      reader.readAsDataURL(file);
      reader.onload = () => {
        this.pessoa.foto = reader.result;
        this.cd.markForCheck();
      };
    }
  }

  openModal(): void {
    const modalRef = this.modalService.open(FormModalComponent);

    modalRef.result.then((result) => {
     this.pessoa.listaVinculo.push(result);
    }).catch((error) => {
      this.mensagemFactory.publicaMensagemErro(error);
    });
  }

  salvar(): void {
    this.mensagemFactory.publicaMensagemSucesso('Salvo com Sucesso.');
  }

  deletarVinculo(index: number): void {
    this.mensagemFactory.publicaMensagemConfirmacao('Deseja excluir o vinculo?', 'ao confirmar o vinculo sera removido.')
      .then(result => {
        if (result.value) {
          this.pessoa.listaVinculo.splice(index, 1);
        }
      });
  }
}
