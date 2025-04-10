# ClinicaOdontologicaNH

Este es un sistema de gestión para un consultorio odontológico, se desarrolló en Java usando tecnologías como JSP, Servlets, JPA, HTML/CSS, y utilizando WAMP Server para la base de datos MySQL. Todo fue realizado sobre la IDE de NetBeans. 

El objetivo del proyecto es brindar una herramienta que permita administrar de forma sencilla pacientes, usuarios, y odontólogos. Si el usuario es un simple paciente tiene un acceso limitado a ciertos aspectos, si es un administrador puede realizar todas las acciones posibles en el sistema.

Principales funciones:
  -Registro, edición y eliminación de usuarios (con control de roles: admin y user).
  -Alta, edición y baja de pacientes, con validación de datos.
  -Inicio y cierre de sesión (sistema de login).
  -Restricción de acceso a páginas si el usuario no está logueado.
  -Control de errores y mensajes informativos en pantalla (tratando excepciones).
  -Panel para ver todos los usuarios registrados.

Tecnologías utilizadas:
  -Java
  -Servlets
  -JSP
  -Apache Tomcat
  -HTML5/CSS3
  -JPA (Java Persistence API)
  -MySQL (WAMP Server)
  -Maven
