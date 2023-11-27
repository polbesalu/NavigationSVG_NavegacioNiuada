package cat.institutmontilivi.navigation3.Navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import cat.institutmontilivi.navigation3.Dades.Cotxe
import cat.institutmontilivi.navigation3.Dades.Guerrer
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaContingutCotxe
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaContingutGos
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaContingutGuerrer
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaLlistaDeCotxes
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaLlistaDeGossos
import cat.institutmontilivi.navigation3.ui.Pantalles.PantallaLlistaDeGuerrers

@Composable
fun GraphNAvigation(controladorDeNavegacio: NavHostController = rememberNavController()) {
    NavHost(
        navController = controladorDeNavegacio,
        startDestination = CategoriaDeNavegacio.CategoriaGossos.rutaPrevia
    )
    {
        navigation(
            startDestination = Destinacio.LlistaGossos.rutaBase,
            route = CategoriaDeNavegacio.CategoriaGossos.rutaPrevia
        ) {
            composable(route = Destinacio.LlistaGossos.rutaGenerica) {
                PantallaLlistaDeGossos(titol = "Llista de gossos",
                    onContingutClick = {id:Int -> controladorDeNavegacio.navigate(Destinacio.ContingutGos.CreaRutaAmbArguments(idGos = id))})
            }
            composable(
                route = Destinacio.ContingutGos.rutaGenerica,
                arguments = Destinacio.ContingutGos.navArgs
            ) {
                val numero = it.arguments?.getInt(ArgumentDeNavegacio.GossosContent.clau)
                requireNotNull(numero)
                PantallaContingutGos(id = numero)
            }
        }
        navigation(
            startDestination = Destinacio.LlistaCotxes.rutaBase,
            route = CategoriaDeNavegacio.CategoriaCotxes.rutaPrevia
        ) {
            composable(route = Destinacio.LlistaCotxes.rutaGenerica) {
                PantallaLlistaDeCotxes(titol = "Llista de cotxes",
                    onContingutClick = {id:Int -> controladorDeNavegacio.navigate(Destinacio.ContingutCotxe.CreaRutaAmbArguments(id))})
            }
            composable(
                route = Destinacio.ContingutCotxe.rutaGenerica,
                arguments = Destinacio.ContingutCotxe.navArgs
            ) {
                val numero = it.arguments?.getInt(ArgumentDeNavegacio.CotxeContent.clau)
                requireNotNull(numero)
                PantallaContingutCotxe(id = numero)
            }
        }
        navigation(
            startDestination = Destinacio.LlistaGuerrers.rutaBase,
            route = CategoriaDeNavegacio.CategoriaGuerrers.rutaPrevia
        ) {
            composable(route = Destinacio.LlistaGuerrers.rutaGenerica) {
                PantallaLlistaDeGuerrers(titol = "Llista de guerrers",
                    onContingutClick = {id:Int -> controladorDeNavegacio.navigate(Destinacio.ContingutGuerrer.CreaRutaAmbArguments(id))})
            }
            composable(
                route = Destinacio.ContingutGuerrer.rutaGenerica,
                arguments = Destinacio.ContingutGuerrer.navArgs
            ) {
                val numero = it.arguments?.getInt(ArgumentDeNavegacio.GuerrerContent.clau)
                requireNotNull(numero)
                PantallaContingutGuerrer(id = numero)
            }
        }
    }
}