package cat.institutmontilivi.navigation3.ui.Pantalles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.institutmontilivi.navigation3.Dades.Guerrer
import cat.institutmontilivi.navigation3.Dades.Guerrers
import cat.institutmontilivi.navigationsvg.R
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaLlistaDeGuerrers(titol: String, onContingutClick: (Int) -> Unit) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
    )
    {
        item {Text(text = titol, fontSize = 45.sp)}
        items(Guerrers.dades){
            ListItem(headlineText = { Text(it.nom) }
            , leadingContent = { AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(it.foto)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = stringResource(R.string.superguerrer),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape)
                )}, modifier = Modifier.clickable { onContingutClick(it.id) },
                supportingText = {Text(stringResource(R.string.for_a) + it.forsa.toString())},
                shadowElevation = 10.dp)

        }
    }
}