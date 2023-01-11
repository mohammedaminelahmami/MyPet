/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      colors: {
        "primary": "#e0a526", //
        "primaryhover": "#cf900a", //
        "secondary": "#ff5722",
        "info": "#00acc1",
        "warning": "#ff9800",
        "danger": "#f44336",
      }
    },
  },
  plugins: [],
}