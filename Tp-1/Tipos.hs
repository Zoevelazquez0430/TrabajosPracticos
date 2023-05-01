module Tipos where

import Data.List

type Datos = String 
type Etiqueta = String 
type Nombre = String

insertar :: Ord a => a -> [a] -> [a]
insertar elemento lista = sort (elemento:lista)

--testing
elemento= 2
lista = [4,6,1]

testing=[
    insertar elemento lista == [1,2,4,6]
    ]