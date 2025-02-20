package br.com.tokiomarine.payschedulertokiomarine.constants;

public class MessageConstants {

    public static final String TAX_NOT_FOUND = "Taxa não encontrada para o período especificado.";
    public static final String ACCOUNT_NOT_FOUND = "conta não encontrada para o período especificado.";
    public static final String INVALID_DATE = "A data fornecida é inválida.";
    public static final String ERROR = "error";
    public static final String USE_CPF = "JÁ EXISTE UM USUÁRIO COM ESSE CPF";
    public static final String ERRO_TOKEN = "Erro ao gerar o token";
    public static final String NO_BALANCE = "Saldo insuficiente para realizar a transferência.";

    private MessageConstants() {
        throw new UnsupportedOperationException("Esta é uma classe utilitária e não pode ser instanciada.");
    }
}
