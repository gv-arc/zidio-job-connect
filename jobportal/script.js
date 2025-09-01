
document.addEventListener('DOMContentLoaded', () => {
  // Animate stat counters
  document.querySelectorAll('.stat-number').forEach(el => {
    const target = +el.dataset.count;
    let n = 0;
    const step = Math.max(1, Math.floor(target/120));
    const int = setInterval(()=>{
      n += step;
      if(n>=target){ n = target; clearInterval(int); }
      el.textContent = n.toLocaleString();
    }, 12);
  });

  // Populate Browse Jobs grid with sample cards
  const grid = document.getElementById('jobsGrid');
  if(grid){
    const jobs = [
      {title:'React Developer', comp:'Sizekit', loc:'Hyderabad', type:'Full-Time'},
      {title:'Java Backend Engineer', comp:'Cognizant', loc:'Bengaluru', type:'Full-Time'},
      {title:'QA Tester', comp:'Infosys', loc:'Pune', type:'Contract'},
      {title:'UI/UX Designer', comp:'Amazon', loc:'Hyderabad', type:'Part-Time'},
      {title:'Data Analyst', comp:'IBM', loc:'Chennai', type:'Full-Time'},
      {title:'DevOps Engineer', comp:'TechM', loc:'Remote', type:'Remote'},
    ];
    jobs.forEach(j => {
      const col = document.createElement('div');
      col.className = 'col-12 col-md-6 col-lg-4';
      col.innerHTML = `
        <div class="job-list p-4 h-100">
          <h6 class="mb-1">${j.title} <span class="badge bg-dark rounded-pill">${j.type}</span></h6>
          <div class="text-secondary small mb-2">${j.comp} • ${j.loc}</div>
          <div class="d-flex justify-content-between">
            <a href="#" class="btn btn-sm btn-outline-secondary">Details</a>
            <a href="#" class="btn btn-sm btn-danger">Apply</a>
          </div>
        </div>`;
      grid.appendChild(col);
    });
  }
});
