# Proyecto-Academia-IBM-Microservicios
Ejercicios del proyecto de la academia de microservicios

*Ambos ejercicios requieren de que **EurekaServer** esté levantado para su correcto funcionamiento.*

## Ejercicio 1:

Esta API recibe los parámetros:
- passion (una o varias pasiones separadas por ',')
- salary (salario mensual)
- age (edad)

Se procesa la solicitud y retorna un listado de las tarjetas de crédito según sean los parámetros anteriores como se muestra a continuación:

- Producer
***Endpoint** http://localhost:8762/creditCard/availableCreditCards/{passion}/{salary}/{age}*

![image](https://user-images.githubusercontent.com/51681773/137646426-add82a07-789e-4972-b022-8a7089d15234.png)
![image](https://user-images.githubusercontent.com/51681773/137646399-a8985205-c519-43f5-a7de-34f65b54c281.png)

- Consumer
***Endpoint** http://localhost:9100/client/availableCreditCards/{passion}/{salary}/{age}*

![image](https://user-images.githubusercontent.com/51681773/137646478-0231d9f1-7d50-4787-820e-98e8c91ccfc0.png)
![image](https://user-images.githubusercontent.com/51681773/137646500-c308b5d0-4e14-45a7-9613-f775f4456961.png)


## Ejercicio 2:

Esta API recibe los parámetros:
- GPS (en el orden 'latitud, longitud')

Se procesa la solicitud y retorna un listado de cajeros y sucursales que estén a una distancia menor igual a 5km como se muestra a continuación:
- Producer
***Endpoint** http://localhost:9000/bank/location/{gps}*
![image](https://user-images.githubusercontent.com/51681773/137647247-213cc17d-0e36-46b9-99fe-0996a436d225.png)

- Consumer
***Endpoint** http://localhost:9100/client/searchBank/{gps}*
![image](https://user-images.githubusercontent.com/51681773/137647295-3475550f-c308-4382-9c7a-09b4421122d9.png)
