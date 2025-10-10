package features;

import core.SubMenu;

public class MenuAbleSisitemaStock extends SubMenu {

    public MenuAbleSisitemaStock(String titulo) {
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
