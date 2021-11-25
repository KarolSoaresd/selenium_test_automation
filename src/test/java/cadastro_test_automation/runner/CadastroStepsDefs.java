package cadastro_test_automation.runner;

import cadastro_test_automation.web.CadastroPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CadastroStepsDefs {

    CadastroPage paginaDeCadastro;

    @Dado("Que estou na página de cadastro")
    public void que_estou_na_página_de_cadastro() {
        this.paginaDeCadastro = new CadastroPage();
    }

    @Quando("Preencho todos os campos e o campo de nome com o dado inválido")
    public void preencho_todos_os_campos_e_o_campo_de_nome_com_o_dado_inválido() {
        this.paginaDeCadastro.preencherNome("karol");
        this.paginaDeCadastro.preencherEmail("karol.santos@gmail.com");
        this.paginaDeCadastro.preencherSenha("12345678");
    }

    @Quando("Efetuo cadastro")
    public void efetuo_cadastro() {
        this.paginaDeCadastro.efetuarCadastro();
    }

    @Então("Aparece informativo que o nome é inválido")
    public void aparece_informativo_que_o_nome_é_inválido() {
        Assert.assertTrue(paginaDeCadastro.isMensagemDeErroNome());
        Assert.assertTrue(paginaDeCadastro.isPaginaAtual());
        this.paginaDeCadastro.fechar();
    }

    @Quando("Preencho todos os campos e o campo de e-mail com o dado inválido")
    public void preencho_todos_os_campos_e_o_campo_de_e_mail_com_o_dado_inválido() {
        this.paginaDeCadastro.preencherNome("Karoline Soares dos Santos");
        this.paginaDeCadastro.preencherEmail("karol.santos@gmail");
        this.paginaDeCadastro.preencherSenha("12345678");
    }
    @Então("Aparece informativo que o e-mail é inválido")
    public void aparece_informativo_que_o_e_mail_é_inválido() {
        Assert.assertTrue(paginaDeCadastro.isPaginaAtual());
        Assert.assertFalse(paginaDeCadastro.isMensagemDeErroNome());
        Assert.assertTrue(paginaDeCadastro.isMensagemDeErroEmail());
        this.paginaDeCadastro.fechar();
    }

    @Quando("Preencho todos os campos e o campo de senha com o dado inválido")
    public void preencho_todos_os_campos_e_o_campo_de_senha_com_o_dado_inválido() {
        this.paginaDeCadastro.preencherNome("Karoline Soares dos Santos");
        this.paginaDeCadastro.preencherEmail("karol.santos@gmail.com");
        this.paginaDeCadastro.preencherSenha("1234");
    }

    @Então("Aparece informativo que a senha está inválida")
    public void aparece_informativo_que_a_senha_está_inválida() {
        Assert.assertTrue(paginaDeCadastro.isPaginaAtual());
        Assert.assertTrue(paginaDeCadastro.isMensagemDeErroSenha());
        this.paginaDeCadastro.fechar();
    }

    @Quando("Não preencho os campos")
    public void não_preencho_os_campos() {
        this.paginaDeCadastro.preencherNome("");
        this.paginaDeCadastro.preencherEmail("");
        this.paginaDeCadastro.preencherSenha("");
    }
    @Então("Aparece informativo que campos estão vazios")
    public void aparece_informativo_que_campos_estão_vazios() {
        Assert.assertTrue(paginaDeCadastro.isPaginaAtual());
        Assert.assertTrue(paginaDeCadastro.isMensagensDeCamposEmBrancos());
        this.paginaDeCadastro.fechar();
    }

    @Quando("Preencho corretamente todos os campos")
    public void preenchoCorretamenteTodosOsCampos() {
        this.paginaDeCadastro.preencherNome("Karoline Soares dos Santos");
        this.paginaDeCadastro.preencherEmail("karol.santos@gmail.com");
        this.paginaDeCadastro.preencherSenha("12345678");
    }

    @Então("Cadastro é efetivado")
    public void cadastroÉEfetivado() {
        Assert.assertTrue(paginaDeCadastro.campoDeCadastroRealizados());
        Assert.assertTrue(paginaDeCadastro.emailCadastrado());
        this.paginaDeCadastro.fechar();
    }

    @Então("Excluo o cadastro realizado")
    public void excluoOCadastroRealizado() {
        this.paginaDeCadastro.excluirCadastro();
    }

    @E("O cadastro não aparece mais na tela")
    public void oCadastroNãoApareceMaisNaTela() {
        Assert.assertTrue(paginaDeCadastro.isPaginaAtual());
        Assert.assertNull(paginaDeCadastro.camposVazios("","",""));
        Assert.assertFalse(paginaDeCadastro.campoDeCadastroRealizados());
        this.paginaDeCadastro.fechar();
    }
}
