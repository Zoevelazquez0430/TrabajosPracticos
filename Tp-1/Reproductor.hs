module Reproductor ( Reproductor, nuevoR, archivosR, listaParaR, temasR, playR, actualR, avanzarR, retrocederR,
reiniciarR )
where
import Tipos
import Tema
import Playlist
import FileSystem

data Reproductor = RP FileSystem Playlist deriving (Eq, Show)

nuevoR:: FileSystem -> Reproductor
nuevoR fileSystem = RP fileSystem (nuevaP [])

archivosR:: Reproductor -> FileSystem
archivosR (RP fileSystem _) = fileSystem

listaParaR:: Etiqueta -> Reproductor -> [Tema]
listaParaR etiqueta (RP fileSystem playlist) = filtrarF etiqueta fileSystem

temasR:: Reproductor -> [Tema]
temasR (RP fileSystem playlist) = temasF fileSystem

playR:: Reproductor -> Etiqueta -> Reproductor
playR (RP fileSystem playlist) etiqueta = RP fileSystem (nuevaP (filtrarF etiqueta fileSystem))

actualR:: Reproductor -> Tema
actualR (RP fileSystem playlist) = actualP playlist

avanzarR:: Reproductor -> Reproductor
avanzarR (RP filesystem playlist) = RP filesystem (skipP playlist)

retrocederR:: Reproductor -> Reproductor
retrocederR (RP filesystem playlist) = RP filesystem (backP playlist)

reiniciarR:: Reproductor -> Reproductor
reiniciarR (RP filesystem playlist) = RP filesystem (resetP playlist)

--Testings

fileSPrueba :: FileSystem
fileSPrueba= nuevoF

temaBase1 :: Tema
temaBase1= nuevoT "Thunderstruck" "1990"
temaBase2 :: Tema
temaBase2= nuevoT "Back in black" "1980"
tema1 :: Tema
tema1= agregarT "Rock" temaBase1
tema2 :: Tema
tema2= agregarT "Rock" temaBase2

playlistPrueba :: Playlist
playlistPrueba= nuevaP [tema1, tema2]

fileBase1 :: FileSystem
fileBase1= agregarF tema1 fileSPrueba
fileSysTest :: FileSystem
fileSysTest= agregarF tema2 fileBase1


repBase :: Reproductor
repBase= nuevoR fileSPrueba
repTest :: Reproductor
repTest = nuevoR fileSysTest
repTest2 :: Reproductor
repTest2 = RP fileSysTest playlistPrueba

testings :: [Bool]
testings=[
    repBase == nuevoR fileSPrueba,
    archivosR repTest == fileSysTest,
    listaParaR "Rock" repTest == [tema2,tema1],
    temasR repTest== [tema2,tema1],
    playR repTest2 "Rock" == RP fileSysTest (nuevaP [tema2,tema1]),
    actualR repTest2 == tema1,
    avanzarR repTest2 == RP fileSysTest (skipP playlistPrueba),
    retrocederR repTest2 == RP fileSysTest (backP playlistPrueba),
    reiniciarR repTest2 == RP fileSysTest (resetP playlistPrueba)
    ]