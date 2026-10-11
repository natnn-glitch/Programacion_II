# clases.py

class Sensor:
    # ATRIBUTO DE CLASE: se define en la clase y es el mismo para todos sus objetos
    tipo = "Genérico"

    def __init__(self, id, **kwargs):
        super().__init__(**kwargs)
        # ATRIBUTOS DE INSTANCIA: cada objeto tiene su propio valor
        self.id = id
        self.encendido = False

    def activar(self):
        self.encendido = True
        print(f"{self.tipo} {self.id}: activado")

    def desactivar(self):
        self.encendido = False
        print(f"{self.tipo} {self.id}: desactivado")


class Camara(Sensor):
    # ATRIBUTO DE CLASE (redefine el tipo de Sensor)
    tipo = "Cámara"

    def __init__(self, id, resolucion, **kwargs):
        super().__init__(id=id, **kwargs)
        # ATRIBUTO DE INSTANCIA
        self.resolucion = resolucion


class SensorLuzLaser(Sensor):
    # ATRIBUTO DE CLASE (redefine el tipo de Sensor)
    tipo = "Luz Laser"

    def __init__(self, id, alcance, **kwargs):
        super().__init__(id=id, **kwargs)
        # ATRIBUTO DE INSTANCIA
        self.alcance = alcance


# Herencia multiple: VehiculoAutonomo hereda de Camara y de SensorLuzLaser
class VehiculoAutonomo(Camara, SensorLuzLaser):
    # ATRIBUTO DE CLASE (redefine el tipo)
    tipo = "Vehículo Autónomo"

    def __init__(self, id, resolucion, alcance):
        # Cada clase de la cadena toma lo suyo y pasa el resto con **kwargs
        super().__init__(id=id, resolucion=resolucion, alcance=alcance)
