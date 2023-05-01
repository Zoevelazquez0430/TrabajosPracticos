module Tema (Tema, nuevoT, nombreT, datosT, etiquetasT, agregarT, aplicaT )
where
import Tipos
data Tema = Tem Nombre [ Etiqueta ] Datos deriving (Eq, Show, Ord)

nuevoT :: Nombre -> Datos -> Tema
nuevoT nombre = Tem nombre []

nombreT :: Tema -> Nombre
nombreT (Tem nombre _ _) = nombre

datosT :: Tema -> Datos
datosT (Tem _ _ datos) = datos

etiquetasT :: Tema -> [Etiqueta]
etiquetasT (Tem _ etiquetas _) = etiquetas

agregarT :: Etiqueta -> Tema -> Tema
agregarT nuevaEtiqueta (Tem nombre etiqueta datos) = Tem nombre (nuevaEtiqueta:etiqueta) datos

aplicaT :: Etiqueta -> Tema -> Bool
aplicaT checkEtiqueta (Tem _ etiqueta _) = checkEtiqueta `elem`etiqueta


--Testings

testings :: [Bool]
testings=[
    nuevoT "Thunderstruck" "1990" == Tem "Thunderstruck" [] "1990", 
    nombreT (Tem "Thunderstruck" ["rock"] "1990") == "Thunderstruck",
    datosT (Tem "Thunderstruck" ["rock"] "1990") == "1990",
    etiquetasT (Tem "Thunderstruck" ["rock"] "1990") == ["rock"],
    agregarT "heavy metal" (Tem "Thunderstruck" ["rock"] "1990") == Tem "Thunderstruck" ["heavy metal", "rock"] "1990",
    aplicaT "pop" (Tem "Thunderstruck" ["rock"] "1990")==False
    ]