package cat.institutmontilivi.navigationsvg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cat.institutmontilivi.navigation3.Navigation.CategoriaDeNavegacio
import cat.institutmontilivi.navigation3.Navigation.GraphNAvigation
import cat.institutmontilivi.navigationsvg.ui.theme.NavigationSVGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationSVGTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Aplicacio {

                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Aplicacio(content: @Composable () -> Unit = {Text("")}){
    PantallaDeLAplicacio {
        val controladorDeNavegacio = rememberNavController()
        val navBackStackEntry by controladorDeNavegacio.currentBackStackEntryAsState()
        val rutaActual = navBackStackEntry?.destination?.route?:""
        Scaffold (
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(R.string.navegaci_niuada)) },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    navigationIcon = { Image(
                        //add own image
                        painterResource(id = R.drawable.drive), contentDescription = "sail",
                        contentScale = ContentScale.Inside,
                        modifier = Modifier.height(32.dp))
                    })
            },
            bottomBar = {
                NavigationBar {
                    CategoriaDeNavegacio.values().forEach {
                        NavigationBarItem(label = {Text(stringResource(id = it.titol))},
                            selected = rutaActual.contains(it.rutaPrevia),
                            onClick = { controladorDeNavegacio.navigate(it.rutaPrevia)
                            {popUpTo(controladorDeNavegacio.graph.findStartDestination().id){
                                saveState = true
                            }
                                launchSingleTop = true
                                restoreState = true
                            } },
                            icon = { Icon(imageVector = it.icona, contentDescription = stringResource(
                                id = it.titol)
                            ) })
                    }
                }
            }
        ) {
            Box(modifier = Modifier.padding(paddingValues = it)){
                GraphNAvigation(controladorDeNavegacio)
            }
        }
    }
}

@Composable
fun PantallaDeLAplicacio (content: @Composable ()->Unit)
{
    NavigationSVGTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}