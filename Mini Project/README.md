# UPI-Style Peer-to-Peer Wallet

Console-based JDBC mini project based on the assessment brief.

## Features

- User registration and login
- Wallet balance top-up
- Peer-to-peer money transfer with transaction handling
- Transaction history
- Monthly summary
- Statement export to `.txt` and `.csv`
- UPI ID masking

## Project Structure

- `schema.sql` - database tables
- `src/wallet` - Java source files

## Database Setup

1. Use SQLite for local development.
2. Run the SQL from `schema.sql` to create the tables in `wallet.db`.
3. Optionally set `WALLET_DB_URL` if you want a different SQLite file:

```powershell
$env:WALLET_DB_URL="jdbc:sqlite:C:\path\to\wallet.db"
```

If `WALLET_DB_URL` is not set, the application uses `jdbc:sqlite:wallet.db` by default.

## Compile

```powershell
javac -d out src\wallet\*.java
```

## Run

Download the SQLite JDBC driver jar (for example `sqlite-jdbc-<version>.jar`) and run:

```powershell
java -cp "out;sqlite-jdbc-<version>.jar" wallet.Main
```

## Notes

- The project uses `BigDecimal` for money values.
- Passwords are stored as plain text only to match the academic brief. Real projects should hash them.
