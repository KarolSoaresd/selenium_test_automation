package cadastro.test.automation;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CadastroTest {
    private CadastroPage paginaDeCadastro;

    @BeforeEach
    public void beforeEach(){
        this.paginaDeCadastro = new CadastroPage();
    }

    @AfterEach
    public void afterEach(){
        this.paginaDeCadastro.fechar();
    }

    @Test
    public void preencherFormularioDeCadastroComNomeInválido(){
        this.paginaDeCadastro.preencherNome("karol");
        this.paginaDeCadastro.preencherEmail("karol.santos@gmail.com");
        this.paginaDeCadastro.preencherSenha("12345678");

        this.paginaDeCadastro.efetuarCadastro();

        Assert.assertTrue(paginaDeCadastro.isMensagemDeErroNome());
        Assert.assertTrue(paginaDeCadastro.isPaginaAtual());
    }

    @Test
    public void preencherFormularioComEmailInvalido(){
        this.paginaDeCadastro.preencherNome("Karoline Soares dos Santos");
        this.paginaDeCadastro.preencherEmail("karol.santos@gmail");
        this.paginaDeCadastro.preencherSenha("12345678");
        this.paginaDeCadastro.efetuarCadastro();

        Assert.assertTrue(paginaDeCadastro.isPaginaAtual());
        Assert.assertFalse(paginaDeCadastro.isMensagemDeErroNome());
        Assert.assertTrue(paginaDeCadastro.isMensagemDeErroEmail());
    }

    @Test
    public void preencheFormularioComSenhaInvalida(){
        this.paginaDeCadastro.preencherNome("Karoline Soares dos Santos");
        this.paginaDeCadastro.preencherEmail("karol.santos@gmail.com");
        this.paginaDeCadastro.preencherSenha("1234");
        this.paginaDeCadastro.efetuarCadastro();

        Assert.assertTrue(paginaDeCadastro.isPaginaAtual());
        Assert.assertTrue(paginaDeCadastro.isMensagemDeErroSenha());
    }

    @Test
    public void cadastroComCamposEmBranco(){
        this.paginaDeCadastro.preencherNome("");
        this.paginaDeCadastro.preencherEmail("");
        this.paginaDeCadastro.preencherSenha("");
        this.paginaDeCadastro.efetuarCadastro();

        Assert.assertTrue(paginaDeCadastro.isPaginaAtual());
        Assert.assertTrue(paginaDeCadastro.isMensagensDeCamposEmBrancos());
    }

    @Test
    public void cadastroFuncionaDadosCorretos(){
        this.paginaDeCadastro.preencherNome("Karoline Soares dos Santos");
        this.paginaDeCadastro.preencherEmail("karol.santos@gmail.com");
        this.paginaDeCadastro.preencherSenha("12345678");
        this.paginaDeCadastro.efetuarCadastro();

        Assert.assertTrue(paginaDeCadastro.campoDeCadastroRealizados());
        Assert.assertTrue(paginaDeCadastro.emailCadastrado());
    }
}
