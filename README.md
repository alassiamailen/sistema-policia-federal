# Sistema de Gestión Policial

## 🛡️ Trabajo Práctico Nº1 - Programación II

Este sistema gestiona la información sobre la seguridad de entidades bancarias bajo la supervisión de la Policía Federal Argentina. Está diseñado utilizando principios de orientación a objetos: **abstracción**, **encapsulamiento**, **herencia**, **polimorfismo** y **persistencia por consola** (sin base de datos).

---

## 🧾 Requisitos del sistema

El sistema permite registrar y consultar información sobre:

- Entidades bancarias y sus sucursales.
- Vigilantes contratados para cada sucursal.
- Personas detenidas por delitos en entidades.
- Bandas delictivas a las que podrían pertenecer los detenidos.
- Fechas y lugares de los asaltos.
- Jueces que han intervenido en los casos.

---

## 🔐 Control de acceso

Se implementa un sistema de acceso basado en permisos y roles:

- **Administrador**: puede crear usuarios, roles, asignar permisos, consultar y editar toda la información.
- **Investigador**: puede consultar todos los datos del sistema.
- **Vigilante**: solo puede consultar sus propios datos.

Cada operación del sistema está asociada a un permiso específico. Los permisos se agrupan en roles y se asignan a los usuarios.

---

## 📌 Funcionalidades destacadas

- Crear y administrar entidades bancarias y sucursales.
- Contratar vigilantes por fecha, sucursal y con opción de portar armas.
- Registrar detenidos, bandas organizadas y jueces que intervinieron.
- Consultar historial de asaltos por persona o sucursal.
- Abrir nuevos casos judiciales.
- Sistema de inicio/cierre de sesión con control de permisos.
- Menú interactivo por consola.

---

## 📦 Estructura del proyecto

```plaintext
src/
├── entidades/         # Clases modelo (Entidad, Sucursal, Vigilante, etc.)
├── seguridad/         # Roles, Permisos y control de acceso
├── sistema/           # Lógica de negocio y controladores
├── ui/                # Entrada por consola
└── Main.java          # Punto de entrada del sistema

---

## 🧪 Requisitos técnicos

- Java 8+
- Interfaz por consola (**NO GUI**)
- Uso de Git para control de versiones
- UML generado en [PlantUML](https://plantuml.com/es) y exportado como PNG

## 📁 Entregables

- Código fuente en Java (`.java`)
- Ejecutable (`.jar`)
- Documentación generada con `javadoc`
- Diagramas UML: clases y casos de uso (`.png`)
- Archivo `README.md` explicativo (este mismo)

## 🔗 Recursos útiles

- Policía Federal Argentina: [policia-federal-argentina](https://www.argentina.gob.ar/policia-federal-argentina)
- Generador PlantUML online: [plantUML] https://plantuml.com/es/
- Umletino: [umletino] https://www.umletino.com/umletino.html

## ✍️ Autores

- Alassia Mailén
- Nicolás Guinzio
- Leonel Rivera

```
