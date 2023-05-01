module FileSystem ( FileSystem, nuevoF, etiquetasF, temasF, agregarF, filtrarF )
where
import Tipos
import Tema
data FileSystem = FS [Etiqueta] [Tema] deriving (Eq, Show)

nuevoF:: FileSystem
nuevoF = FS [] []

etiquetasF:: FileSystem -> [Etiqueta]
etiquetasF (FS etiquetas _) = etiquetas

temasF:: FileSystem -> [Tema]
temasF (FS _ temas) = temas

agregarF:: Tema -> FileSystem -> FileSystem
agregarF nuevoTema (FS etiquetas temas) | nuevoTema `notElem` temas = FS etiquetas (nuevoTema:temas) 
                                        |otherwise = FS etiquetas temas


filtrarF:: Etiqueta -> FileSystem -> [Tema]
filtrarF etiqueta (FS etiquetas temas) = [t |t <- temas, aplicaT etiqueta t]

--testings
fileSystBase :: FileSystem
fileSystBase= nuevoF
temaBase :: Tema
temaBase= nuevoT "Thunderstruck" "1990"
tema :: Tema
tema= agregarT "Rock" temaBase
--tema = Tem "Thunderstruck" ["Rock"] "1990"

file1 :: FileSystem
file1= agregarF tema fileSystBase

testings :: [Bool]
testings=[
    fileSystBase == FS [] [],
    etiquetasF file1 == [],
    temasF file1 == [tema],
    agregarF tema fileSystBase == file1,
    agregarF tema file1== file1,
    filtrarF "Rock" file1 == [tema]
    ]