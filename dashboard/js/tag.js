<block>
  <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">{data.value}</div>
                                    <div>{data.title}!</div>
                                </div>
                            </div>
                        </div>
                      
                    </div>

  <script>
  
    this.data = opts;

    this.on('mount', function() {
    // right after the tag is mounted on the page
        console.log(this.data);
    })
  </script>

</block>

<tabledetail>
    <table class="table table-bordered table-hover table-striped">
        <thead>
            <tr>
                <th>#</th>
                <th>Time</th>
                <th>Status</th>
              
            </tr>
        </thead>
        <tbody>
            <tr each={item in data} >
                <td>{item.idRequest}</td>
                <td>{item.date}</td>
                <td>{item.status}</td>
           
            </tr>
            
        </tbody>
    </table>
    
    <script>
  
    this.data = opts.data;
    this.idkey = opts.idkey;
    this.status = opts.status;
    var _this = this;
    this.on('mount', function() {
    // right after the tag is mounted on the page
        console.log(this.data);
     
        setInterval(function(){
        	

        	  
        	 getByStatus(_this.status, function(data){
        		_this.updateData(data);
              });
        	
        	
        },2000);

       
    })

    updateData(data, idkey)
    {
      this.data = data;
      this.idkey = idkey;
      this.update();
    }    
  </script>
    
</tabledetail>