31---32---33-Mejores-practicas
# Actividad Integral: Principios SOLID en Java

Este repositorio contiene la refactorización de código fuente en Java aplicando las mejores prácticas de desarrollo de software basadas en los cinco principios SOLID. El objetivo principal ha sido reducir el acoplamiento, aumentar la cohesión y asegurar la escalabilidad del sistema.

---

## 1. Single Responsibility Principle (SRP)

**¿Cómo se aplicó el principio revisado?**
En el proyecto base, la clase `UserManager` violaba el principio SRP al centralizar la validación de reglas de negocio, la persistencia en base de datos y el envío de notificaciones. Para refactorizarlo, dividimos estas responsabilidades en clases especializadas:
* `UserValidator`: Valida el formato del correo y longitud de contraseña.
* `UserRepository`: Simula la persistencia de datos.
* `NotificationService`: Maneja comunicaciones externas.
* `UserManager`: Se transformó en un orquestador que recibe estas dependencias inyectadas.

**¿Qué problemas resolvió?**
Eliminó el alto acoplamiento. Ahora una modificación en la base de datos no afectará la validación. Aumentó la cohesión y facilitó enormemente la creación de pruebas unitarias aisladas para cada módulo.



---

## 2. Open/Closed Principle (OCP)

**¿Cómo se aplicó el principio revisado?**
La clase `NotificationService` utilizaba una estructura de control `if/else` para determinar el tipo de notificación, lo que obligaba a modificar la clase para agregar nuevos canales. Refactorizamos utilizando polimorfismo: creamos la interfaz `Notification` y clases concretas (`EmailNotification`, `SMSNotification`). Ahora el servicio recibe cualquier objeto que implemente la interfaz.

**¿Qué problemas resolvió?**
La clase quedó **cerrada a la modificación** pero **abierta a la extensión**. Redujo la complejidad ciclomática al eliminar condicionales y previno la introducción de *bugs* al agregar nuevos métodos de notificación.

+

---

## 3. Liskov Substitution Principle (LSP)

**¿Cómo se aplicó el principio revisado?**
La clase `Fish` heredaba de `Animal` el método `walk()`, el cual lanzaba una excepción al no poder implementarlo. Para solucionarlo, adelantamos la clase base `Animal` (dejando solo `makeSound()`) y creamos la interfaz específica `Walkable` para animales que caminan (como `Dog`).

**¿Qué problemas resolvió?**
Previno errores catastróficos en tiempo de ejecución (Runtime Exceptions) por operaciones no soportadas. Garantizó un polimorfismo seguro, donde las clases derivadas realmente pueden sustituir a sus clases base sin fallar.

---

## 4. Interface Segregation Principle (ISP)

**¿Cómo se aplicó el principio revisado?**
La interfaz `Device` era demasiado monolítica (exigía métodos de encendido y recarga). Esto obligaba a la `DisposableCamera` a implementar un método de recarga inútil. Segregamos esta interfaz en dos: `Switchable` y `Chargeable`.

**¿Qué problemas resolvió?**
Eliminó las dependencias a métodos no utilizados ("Fat Interfaces"). Hizo el código más limpio y flexible para integrar futuros dispositivos con capacidades limitadas sin forzarlos a lanzar excepciones.



## 5. Dependency Inversion Principle (DIP)

**¿Cómo se aplicó el principio revisado?**
La clase `PaymentProcessor` (alto nivel) instanciaba directamente a `CreditCardPayment` (bajo nivel) en su constructor. Invertimos el control creando la interfaz `PaymentMethod`. Ahora, el procesador recibe por constructor cualquier método de pago que cumpla con la interfaz (Inyección de Dependencias).

**¿Qué problemas resolvió?**
Desacopló totalmente la lógica de negocio de los detalles de implementación de la pasarela de pago. Permite la integración de nuevos sistemas (PayPal, Crypto) sin modificar el núcleo y habilita la creación de *Mocks* para pruebas unitarias exactas.
