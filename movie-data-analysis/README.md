# Movie Data Analysis

A collection of Jupyter notebooks and datasets for movie, IMDb and box-office data collection and analysis.

## Context

Télécom Paris engineering coursework. The project year is not recorded in the repository.

## What it includes

- Notebooks for IMDb and box-office data collection, plus spreadsheet-based analyses.
- Movie, actor and role datasets in CSV and Excel formats.
- `RawData.xlsx` and derived data files under `Data/`.

## Tech stack

Python, Jupyter, pandas, Matplotlib, openpyxl, Selenium and WebDriver Manager.

## How to run

Install the notebook dependencies with `python -m pip install jupyter pandas matplotlib openpyxl selenium webdriver-manager`. Open the analysis notebooks in Jupyter from their containing directory. The collection notebooks use Selenium and require a compatible Chrome installation; `DataBoxOffice.ipynb` reads `../Data/RawData.csv` and writes a timestamped CSV in `Code/`.

## Folder contents

- `Code/` — collection notebooks, analysis notebook and a movie dataset.
- `Data/` — source spreadsheets, CSV datasets and an additional analysis notebook.
