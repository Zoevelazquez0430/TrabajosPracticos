{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Eta reduce" #-}
module Playlist ( Playlist, nuevaP, actualP, skipP, backP, resetP )
where
import Tipos
import Tema
data Playlist = Play Int [ Tema ] deriving (Eq, Show)

nuevaP:: [Tema] -> Playlist
nuevaP = Play 0

actualP:: Playlist -> Tema
actualP (Play indice temas) = temas !! indice

skipP:: Playlist -> Playlist
skipP (Play indice temas) = Play (indice +1) temas

backP:: Playlist -> Playlist
backP (Play indice temas) = Play (indice-1) temas

resetP:: Playlist -> Playlist
resetP (Play indice temas) =  Play 0 temas 


--testings
temaPred1 :: Tema
temaPred1= nuevoT "Thunderstruck" "1990"
temaPred2 :: Tema
temaPred2= nuevoT "Back in black" "1980"

tema1 :: Tema
tema1= agregarT "Rock" temaPred1
tema2 :: Tema
tema2= agregarT "Rock" temaPred2
playlistPrueba :: Playlist
playlistPrueba= nuevaP [tema1, tema2]

testings :: [Bool]
testings=[
    playlistPrueba== nuevaP[tema1,tema2],
    actualP playlistPrueba == tema1,
    skipP playlistPrueba == Play 1 [tema1,tema2],
    backP (Play 1 [tema1,tema2]) == playlistPrueba,
    resetP (Play 2 [tema1,tema2])== playlistPrueba,
    resetP playlistPrueba==playlistPrueba
    ]