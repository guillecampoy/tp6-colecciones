package features;

import core.SubMenu;

public class MenuAbleUniversidad extends SubMenu {

    public MenuAbleUniversidad(String titulo) {
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
