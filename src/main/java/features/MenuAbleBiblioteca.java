package features;

import core.SubMenu;
public class MenuAbleBiblioteca extends SubMenu {

    public MenuAbleBiblioteca(String titulo) {
        super(titulo);
    }

    @Override
    protected void imprimirOpciones() {

    }

    @Override
    protected boolean resolverOpcion(int opcion) {
        return false;
    }
}
