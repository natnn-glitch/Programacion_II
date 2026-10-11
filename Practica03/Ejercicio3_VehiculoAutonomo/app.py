# app.py
from clases import Sensor, Camara, SensorLuzLaser, VehiculoAutonomo

sensor = Sensor("S-001")
c1 = Camara("C-001", "1920x1080")
c2 = Camara("C-002", "3840x2160")
laser = SensorLuzLaser("L-001", 150)
vehiculo = VehiculoAutonomo("V-001", "3840x2160", 200)

# Atributos de clase: pertenecen a la clase, se acceden con el nombre de la clase
print("--- Atributos de clase: tipo ---")
print("Sensor.tipo:", Sensor.tipo)
print("Camara.tipo:", Camara.tipo)
print("SensorLuzLaser.tipo:", SensorLuzLaser.tipo)
print("VehiculoAutonomo.tipo:", VehiculoAutonomo.tipo)

# Atributos de instancia: cada objeto tiene los suyos
print()
print("--- Atributos de instancia ---")
print("c1 -> id:", c1.id, "| resolucion:", c1.resolucion, "| encendido:", c1.encendido)
print("c2 -> id:", c2.id, "| resolucion:", c2.resolucion, "| encendido:", c2.encendido)
print("c1.tipo:", c1.tipo, "| c2.tipo:", c2.tipo, "(el mismo, es de la clase)")

# El vehiculo tiene los atributos de instancia de Sensor, Camara y SensorLuzLaser
print()
print("--- VehiculoAutonomo (herencia multiple) ---")
print("id:", vehiculo.id)
print("encendido:", vehiculo.encendido)
print("resolucion:", vehiculo.resolucion)
print("alcance:", vehiculo.alcance)
print("tipo:", vehiculo.tipo)

# Polimorfismo: la misma accion sobre distintos objetos
print()
print("--- activar() y desactivar() ---")
sensores = [sensor, c1, c2, laser, vehiculo]
for s in sensores:
    s.activar()
print("vehiculo encendido:", vehiculo.encendido)
for s in sensores:
    s.desactivar()
print("vehiculo encendido:", vehiculo.encendido)

# Orden de Resolucion de Metodos
print()
print(VehiculoAutonomo.__mro__)
