# Trabajo Práctico 6 – Colecciones y Enumerados

> **Cátedra:** Programación II  
> **Alumno:** Guillermo Campoy  
> **Docente:** Giuliano Espejo  
> **Año/Cuat.**: 2025 / 2C  
> **Lenguaje:** Java (>= 21)
>
## 📌 Objetivo
Desarrollar estructuras de datos dinámicas en Java mediante el uso de **colecciones**
(ArrayList) y **enumeraciones** (enum), implementando diversos ejercicios que refuerzan conceptos clave de la programación
orientada a objetos.
---

## 📂 Estructura del Proyecto

```bash
TP4-POO/
├── src/
│   ├── core/ # Clases de dominio necesarias para el desarrollo de los ejercicios
│   │   ├──                   # TBD
│   │   └──                  # TBD
│   │
│   ├── app/
│   │   └── Main.java                       # Clase con método main, menu simple para ejecución del trabajo
│   │
│   ├── features/ # Clases que sirven para ejecutar los diferentes casos necesarios
│   │   ├──    # TBD
│   │   ├──     # TBD
│   │   ├──   # TBD 
│   │   └──     # TBD
│   │
│   └── utils/
│      ├── ContextColor.java                # Enumerado para establecer contextos para mensajes
│      └── UtilsColor.java                  # Utilitarios para impresión con colores
├── README.md
└── .gitignore
```

---

## 📖 Desarrollo

### 1 - Sistema de stock
- Consideraciones
### 2 - Biblioteca y libros
- Consideraciones 
### 3 - Universidad, profesor y curso 
- Consideraciones

---

### Clase **Main**, con menú que permite:
- Acceder a cada uno de los ejercicios propuestos (sub menús)
- **Submenús** Cada sistema implementa su propio menú para ejecutar las acciones requeridas
---

### Interfaz **Ejecutable**
```java
public interface Ejecutable {
    void ejecutar();
}
```

Todas las clases features (casos de uso) implementan esta interfaz para mantener consistencia en la ejecución.

---
✍️ **Autor:** Guillermo Campoy  
📅 **Año:** 2025