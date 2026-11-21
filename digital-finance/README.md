# MODS205 Digital Finance Project

A Télécom Paris take-home project discussing fintech trends and analyzing Accor and Orange market data against the CAC 40 and a Treasury-bill reference series.

## Context

Télécom Paris MODS205 Digital Finance take-home, 2024–2025. Authors: Iba Demesy and Sernin Marette.

## What it includes

- A written discussion of fintech trends, market microstructure, risk management and regulation.
- Stock-return and moving-average analysis, portfolio comparisons, risk metrics, value-at-risk estimates and simple Accor candlestick-pattern rules.

## Tech stack

Python, Jupyter, NumPy, pandas, Matplotlib, mplfinance, SciPy and seaborn.

## How to run

Install the notebook dependencies:

```bash
python -m pip install jupyter numpy pandas matplotlib mplfinance scipy seaborn
```

Start Jupyter with this folder as its working directory and open `mods205.ipynb`. Its data-loading cell uses the four included CSV files as local paths.

## Folder contents

- `mods205.ipynb` — fintech discussion and financial-data analysis.
- `MODS205.xlsx` and `Take home Digital finance 2024-2025 v1.doc` — course materials.
- `AC.PA.csv`, `ORA.PA.csv`, `^FCHI.csv` and `^IRX.csv` — market data.
