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
Tp6-colecciones/
├── src/
│   ├── core/ # Clases de dominio necesarias para el desarrollo de los ejercicios
│   │   └──                  
│   │
│   ├── app/
│   │   └── Main.java                       # Clase con método main, menu simple para ejecución del trabajo
│   │
│   ├── features/ # Sub menúes para acceder a los diferentes ejercicios
│   │   └──     
│   ├── fixtures/ # Carga de datos de prueba para los ejercicios
│   │   └──    
│   └── utils/
│      ├── ContextColor.java                # Enumerado para establecer contextos para mensajes
│      └── UtilsColor.java                  # Utilitarios para impresión con colores
├── README.md
└── .gitignore
```

### Clase **Main**, con menú que permite:
- Acceder a cada uno de los ejercicios propuestos (sub menús)
- **Submenús** Cada sistema implementa su propio menú para ejecutar las acciones requeridas

---
✍️ **Autor:** Guillermo Campoy  
📅 **Año:** 2025