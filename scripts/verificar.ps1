$ErrorActionPreference = "Stop"
Push-Location (Join-Path $PSScriptRoot "..")
try {
    & .\gradlew.bat :app:assembleDebug
    if ($LASTEXITCODE -ne 0) { throw "La compilación falló. Revisa el primer error de Gradle." }
    Write-Host "APK generado: app\build\outputs\apk\debug\app-debug.apk"
} finally { Pop-Location }
