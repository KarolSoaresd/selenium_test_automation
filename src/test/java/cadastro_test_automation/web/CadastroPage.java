package cadastro_test_automation.web;

import cadastro_test_automation.PageObject;
import org.openqa.selenium.By;

public class CadastroPage extends PageObject {

    private static final String URL_CADASTRO= "http://prova.stefanini-jgr.com.br/teste/qa/";

    public CadastroPage() {
        super(null);
        this.browser.navigate().to(URL_CADASTRO);
    }

    public void preencherNome(String name){

        browser.findElement(By.id("name")).sendKeys(name);
    }

    public void preencherEmail(String email){

        browser.findElement(By.id("email")).sendKeys(email);
    }

    public void preencherSenha(String senha){

        browser.findElement(By.id("password")).sendKeys(senha);
    }

    public void efetuarCadastro(){

        browser.findElement(By.id("register")).click();
    }

    public boolean isMensagemDeErroNome(){
        return browser.getPageSource().contains("Por favor, insira um nome completo.");
    }

    public boolean isPaginaAtual(){
        return browser.getCurrentUrl().equals(URL_CADASTRO);
    }

    public boolean isMensagemDeErroEmail() {
        return browser.getPageSource().contains("Por favor, insira um e-mail válido.");
    }

    public boolean isMensagemDeErroSenha() {
        return browser.getPageSource().contains("A senha deve conter ao menos 8 caracteres.");
    }

    public boolean isMensagensDeCamposEmBrancos() {
        String pageSource = this.browser.getPageSource();
        return pageSource.contains("O campo Nome é obrigatório.")
                && pageSource.contains("O campo E-mail é obrigatório.")
                && pageSource.contains("O campo Senha é obrigatório.");

    }


    public boolean campoDeCadastroRealizados() {
        return browser.getPageSource().contains("Usuários cadastrados");
    }

    public boolean emailCadastrado() {
        return browser.getPageSource().contains("karol.santos@gmail.com");
    }

    public void excluirCadastro() {
        browser.findElement(By.xpath("//*[@id=\"removeUser1\"]")).click();
    }

    public Object camposVazios(String email, String name, String senha) {
        browser.findElement(By.id("email")).sendKeys(email);
        browser.findElement(By.id("password")).sendKeys(senha);
        browser.findElement(By.id("password")).sendKeys(senha);
        return null;
    }
}
