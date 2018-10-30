using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Options;
using Microsoft.EntityFrameworkCore;
using Pivotal.Discovery.Client;
using Steeltoe.Extensions.Configuration.ConfigServer;
using fortune_teller_service.Models;
using fortune_teller_service.Repositories;

namespace fortune_teller_service
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddOptions();

            // Optional: Adds ConfigServerClientOptions to service container
            services.ConfigureConfigServerClientOptions(Configuration);

            // Optional:  Adds IConfiguration and IConfigurationRoot to service container
            services.AddConfiguration(Configuration);

            services.AddEntityFrameworkInMemoryDatabase().AddDbContext<FortuneContext>(
                options => options.UseInMemoryDatabase("Fortunes"), ServiceLifetime.Singleton);
            
            services.AddSingleton<IFortuneRepository, FortuneRepository>();

            services.AddDiscoveryClient(Configuration);

            services.AddMvc().SetCompatibilityVersion(CompatibilityVersion.Version_2_1);
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseMvc();
            app.UseDiscoveryClient();
            SampleData.InitializeFortunesAsync(app.ApplicationServices).Wait();
        }
    }
}
