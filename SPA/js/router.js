const route = (event) => {
    event = event || window.event;
    event.preventDefault(); // Останавливаем стандартное поведение перехода по ссылке
    window.history.pushState({}, "", event.target.href); // Обновляем URL без перезагрузки страницы
    handleLocation(); // Обновляем контент страницы
  };
  
  const routes = {
    404: "./404.html", // Путь к странице 404
    "/": "./pages/home.html", // Путь к главной странице
    "/contacts": "./pages/contacts.html", // Путь к странице контактов
    "/about": "../pages/about.html" // Путь к странице "О нас"
  };
  
  const handleLocation = async () => {
    const path = window.location.pathname; // Получаем текущий путь
    console.log("Current path:", path); // Лог текущего пути
  
    const route = routes[path] || routes[404]; // Получаем путь из маршрутов или путь к 404, если не найдено
    console.log("Selected route:", route); // Лог выбранного маршрута
      const html = await fetch(route).then((data) => data.text()); // Загружаем HTML
      document.getElementById("main-page").innerHTML = html; // Вставляем HTML в элемент    
  };
  
  window.onpopstate = handleLocation; // Обработчик для событий "назад/вперед"
  window.route = route; // Делаем функцию доступной в глобальной области видимости
  
  handleLocation(); // Инициализируем роутинг при загрузке страницы
  