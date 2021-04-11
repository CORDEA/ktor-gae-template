import io.ktor.application.*
import io.ktor.features.*
import org.slf4j.event.Level

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging) {
        level = Level.INFO
    }
}
