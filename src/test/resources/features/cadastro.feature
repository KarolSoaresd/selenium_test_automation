#language:pt
#encoding:UTF-8
#Autor: Karoline-Santos

Funcionalidade: Valida pagina de cadastro

  Cenário: Valida campo nome quando dado é inválido
    Dado Que estou na página de cadastro
    Quando Preencho todos os campos e o campo de nome com o dado inválido
    E Efetuo cadastro
    Então Aparece informativo que o nome é inválido


  Cenário: Valida campo de e-mail quando dado é inválido
    Dado Que estou na página de cadastro
    Quando Preencho todos os campos e o campo de e-mail com o dado inválido
    E Efetuo cadastro
    Então Aparece informativo que o e-mail é inválido

  Cenário: Valida campo de senha quando dado é inválido
    Dado Que estou na página de cadastro
    Quando Preencho todos os campos e o campo de senha com o dado inválido
    E Efetuo cadastro
    Então Aparece informativo que a senha está inválida

  Cenário: Validar funcionalidade de cadastro quando campos estão vazios
    Dado Que estou na página de cadastro
    Quando Não preencho os campos
    E Efetuo cadastro
    Então Aparece informativo que campos estão vazios

  Cenário:Valida cadastro quando dados estão corretos
    Dado Que estou na página de cadastro
    Quando Preencho corretamente todos os campos
    E Efetuo cadastro
    Então Cadastro é efetivado

  Cenário: Valida exclusão de cadastro
    Dado Que estou na página de cadastro
    Quando Preencho corretamente todos os campos
    E Efetuo cadastro
    Então Excluo o cadastro realizado
    E O cadastro não aparece mais na tela

