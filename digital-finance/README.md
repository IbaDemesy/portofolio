# MODS205 Digital Finance Project

A 2024–2025 Digital Finance take-home project at Télécom Paris by Iba Demesy and Sernin Marette. The notebook discusses 2024 fintech trends and analyzes Accor and Orange stock data alongside the CAC 40 and a Treasury-bill reference series.

## What's inside

| File | Description |
| --- | --- |
| `mods205.ipynb` | Fintech trends discussion and financial-data analysis |
| `MODS205.xlsx` | Course project workbook |
| `Take home Digital finance 2024-2025 v1.doc` | Take-home assignment |
| `AC.PA.csv`, `ORA.PA.csv` | Accor and Orange market data |
| `^FCHI.csv` | CAC 40 market data |
| `^IRX.csv` | Treasury-bill reference series |

The notebook covers market microstructure, risk management, and regulation and compliance. Its quantitative sections calculate returns and moving averages, compare the stocks with the CAC 40, examine a 50/50 portfolio and efficient frontier, estimate risk metrics and value at risk, and explore simple candlestick-pattern rules for Accor.

## Tech stack

Python, Jupyter, NumPy, pandas, Matplotlib, mplfinance, SciPy and seaborn.

## How to run

Install the notebook dependencies:

```bash
python -m pip install jupyter numpy pandas matplotlib mplfinance scipy seaborn
```

Open `mods205.ipynb` in Jupyter. Before running, fix the data-loading cell: its checked-in `file_paths` mapping is malformed and points to GitHub page URLs. Use the included CSV files as local paths for `AC`, `ORA`, `Interest_US5W` (`^IRX.csv`) and `CAC40` (`^FCHI.csv`).

## Authors and context

Iba Demesy and Sernin Marette, Télécom Paris MODS205 Digital Finance take-home, 2024–2025.
